Uri uri = Uri.parse(stream);
            OnNewMetadataListener listener = new OnNewMetadataListener() {
                @Override
                public void onNewHeaders(String stringUri, List<String> name, List<String> desc, List<String> br, List<String> genre, List<String> info) {}
                @Override
                public void onNewStreamTitle(String stringUri, String streamTitle) {
                    songinfo.setText("Song Name : "+streamTitle);
                }
            };
            AudiostreamMetadataManager.getInstance()
                    .setUri(uri)
                    .setOnNewMetadataListener(listener)
                    .setUserAgent(UserAgent.WINDOWS_MEDIA_PLAYER)
                    .start();