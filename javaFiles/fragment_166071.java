(let [lock someObject]
  (try
    (monitor-enter lock)
    ;; critical section
    (finally
      (monitor-exit lock))))