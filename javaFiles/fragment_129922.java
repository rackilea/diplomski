(defn create-engine
  "Creates a new nashorn script engine and loads dependencies into its context."
  [dependencies]
  (let [nashorn (.getEngineByName (ScriptEngineManager.) "nashorn")]
    (.eval nashorn "var global = this;")
    (doseq [dependency dependencies] (.eval nashorn (new InputStreamReader (.getResourceAsStream String dependency))))
    nashorn))