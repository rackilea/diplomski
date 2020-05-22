(ns ssh-test.core
  (:use [clj-ssh.ssh]))

(defn test-conn []
  (let [agent (ssh-agent {})]
    (let [session (session agent "127.0.0.1" {:strict-host-key-checking :no})]
      (with-connection session
        (let [ch-a (shell-channel session)
              ch-b (shell-channel session)]
          [ch-a ch-b])))))