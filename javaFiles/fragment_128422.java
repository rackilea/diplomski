I/System.out: JSON: [{"titre":"Le Parachutage","auteur":"Norbert Zongo","categorie":"Litterature","editeur":"Harmattan","prix":"400 UM"}]

              [ 01-02 21:52:56.868  5158: 5176 D/         ]
              HostConnection::get() New Host Connection established 0x79a60fcff600, tid 5176
I/OpenGLRenderer: Initialized EGL, version 1.4
D/OpenGLRenderer: Swap behavior 1
E/EGL_emulation: tid 5176: eglSurfaceAttrib(1174): error 0x3009 (EGL_BAD_MATCH)
W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0x79a605fe2ec0, error=EGL_BAD_MATCH
W/System.err: org.json.JSONException: No value for Titre
W/System.err:     at org.json.JSONObject.get(JSONObject.java:389)
W/System.err:     at org.json.JSONObject.getString(JSONObject.java:550)
W/System.err:     at xyz.selfenrichment.robertotomas.jsonparsing_stackoverflow.MainActivity$getData.onPostExecute(MainActivity.java:78)