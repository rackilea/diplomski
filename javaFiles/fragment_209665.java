(ns net.abhinavsarkar.unicode
  (:import [java.awt.font TextAttribute GlyphVector]
           [java.awt Font]
           [javax.swing JTextArea]))

(let [^java.util.Map text-attrs {
        TextAttribute/FAMILY "Arial Unicode MS"
        TextAttribute/SIZE 25
        TextAttribute/LIGATURES TextAttribute/LIGATURES_ON}
      font (Font/getFont text-attrs)
      ta (doto (JTextArea.) (.setFont font))
      frc (.getFontRenderContext (.getFontMetrics ta font))]
  (defn unicode-partition
    "takes an unicode string and returns a vector of strings by partitioning
    the input string in such a way that multiple code points of a single
    ligature are in same partition in the output vector"
    [^String text]
    (let [glyph-vector 
            (.layoutGlyphVector
              font, frc, (.toCharArray text),
              0, (.length text), Font/LAYOUT_LEFT_TO_RIGHT)
          glyph-num (.getNumGlyphs glyph-vector)
          glyph-positions
            (map first (partition 2
                          (.getGlyphPositions glyph-vector 0 glyph-num nil)))
          glyph-widths
            (map -
              (concat (next glyph-positions)
                      [(.. glyph-vector getLogicalBounds width)])
              glyph-positions)
          glyph-indices 
            (seq (.getGlyphCharIndices glyph-vector 0 glyph-num nil))
          glyph-index-width-map (zipmap glyph-indices glyph-widths)
          corrected-glyph-widths
            (vec (reduce
                    (fn [acc [k v]] (do (aset acc k v) acc))
                    (make-array Float (count glyph-index-width-map))
                    glyph-index-width-map))]
      (loop [idx 0 pidx 0 char-seq text acc []]
        (if (nil? char-seq)
          acc
          (if-not (zero? (nth corrected-glyph-widths idx))
            (recur (inc idx) (inc pidx) (next char-seq)
              (conj acc (str (first char-seq))))
            (recur (inc idx) pidx (next char-seq)
              (assoc acc (dec pidx)
                (str (nth acc (dec pidx)) (first char-seq))))))))))