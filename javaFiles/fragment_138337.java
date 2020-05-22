final Thread cancelable = new Thread() {

            @Override
            public void run() {
                int count;
                try {
                    ...

                    while ((count = input.read(data)) != -1 && !Thread.interrupted()) {
                        total += count;
                        // publishing the progress....
                        // After this onProgressUpdate will be called
                        mListener.onDownloadProgress(mDownloadLink, (int) ((total * 100) / contentLength));

                        // writing data to file
                        output.write(data, 0, count);
                    }
                    if ( Thread.interrupted() ) {
                        mListener.onDownloadCanceled(mDownloadLink);
                    }
                    ...
                }
            }
            }
        });