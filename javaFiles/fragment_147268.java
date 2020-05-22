(let [url-connection
        (doto (java.net.HttpURLConnection.)
          (.setDoInput true)
          ; more initialization
          ))]
  ; use the url-connection
  )