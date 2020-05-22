while ((count = is.read(data)) != -1) { // inside doInBackground
                total += count;
                publishProgress(""+(int)((total*100)/fileLength));
                // writing data to file
                os.write(data, 0, count);
                if(isCancelled())return (null); // ADDED BY ME
            }