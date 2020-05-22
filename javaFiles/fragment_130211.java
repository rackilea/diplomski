(defn createStruct [& args]
  (let [fn- (com.sun.jna.Function/getFunction "some-lib" "createStruct")]
    (.invoke fn- MyStruct (to-array args))))

(defn addStruct [& args]
  (let [fn- (com.sun.jna.Function/getFunction "some-lib" "addStruct")]
    (.invoke fn- Double (to-array args))))

(addStruct (createStruct))
; => 10.14