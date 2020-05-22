(defn test-conn []
  (let [agent (ssh-agent {})]
    (let [session-a (session agent "127.0.0.1" {:strict-host-key-checking :no})
          session-b (session agent "127.0.0.1" {:strict-host-key-checking :no})]
      (with-connection session-a
        (let [ch-a (shell-channel session-a)]
          (with-connection session-b
            (let [ch-b (shell-channel session-b)]
              [ch-a ch-b])))))))