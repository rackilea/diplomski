while ((count = input.read(data)) != -1) {
        if(isCanceled){
           //Do your work here (close stream, delete temp file, send broadcast...)
           break;
        }
        total += count;
        // publishing the progress....
        Bundle resultData = new Bundle();
        resultData.putInt("progress" ,(int) (total * 100 / fileLength));
        receiver.send(UPDATE_PROGRESS, resultData);
        output.write(data, 0, count);
 }