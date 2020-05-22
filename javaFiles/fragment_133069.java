public class UploadFragment extends Fragment implements View.OnClickListener{
private static final int PICK_FILE_REQUEST = 1;
private static final String TAG = MainActivity.class.getSimpleName();
private String selectedFilePath;
private String SERVER_URL = "http://192.168.0.29/aji/AndroidFileUpload/UploadToServer.php";
ImageView ivAttachment;
Button bUpload;
TextView tvFileName;
ProgressDialog dialog;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.upload_frament,container,false);
    ivAttachment = (ImageView) rootView.findViewById(R.id.ivAttachment);
    bUpload = (Button) rootView.findViewById(R.id.b_upload);
    tvFileName = (TextView) rootView.findViewById(R.id.tv_file_name);
    ivAttachment.setOnClickListener(this);
    bUpload.setOnClickListener(this);
    return rootView;
}

@Override
public void onClick(View v) {
    if(v== ivAttachment){

        //on attachment icon click
        showFileChooser();
    }
    if(v== bUpload){

        //on upload button Click
        if(selectedFilePath != null){
            dialog = ProgressDialog.show(getActivity(),"","Uploading File...",true);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //creating new thread to handle Http Operations
                    uploadFile(selectedFilePath);
                }
            }).start();
        }else{
            Toast.makeText(getActivity(),"Please choose a File First",Toast.LENGTH_SHORT).show();
        }

    }
}

private void showFileChooser() {
    Intent intent = new Intent();
    //sets the select file to all types of files
    intent.setType("file/*");
    //allows to select data and return it
    intent.setAction(Intent.ACTION_GET_CONTENT);
    //starts new activity to select file and return data
    startActivityForResult(Intent.createChooser(intent,"Choose File to Upload.."),PICK_FILE_REQUEST);
}

//android upload file to server
public int uploadFile(final String selectedFilePath){

    int serverResponseCode = 0;

    HttpURLConnection connection;
    DataOutputStream dataOutputStream;
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary = "*****";


    int bytesRead,bytesAvailable,bufferSize;
    byte[] buffer;
    int maxBufferSize = 1 * 1024 * 1024;
    File selectedFile = new File(selectedFilePath);


    String[] parts = selectedFilePath.split("/");
    final String fileName = parts[parts.length-1];

    if (!selectedFile.isFile()){
        dialog.dismiss();

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvFileName.setText("Source File Doesn't Exist: " + selectedFilePath);
            }
        });
        return 0;
    }else{
        try{
            FileInputStream fileInputStream = new FileInputStream(selectedFile);
            URL url = new URL(SERVER_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);//Allow Inputs
            connection.setDoOutput(true);//Allow Outputs
            connection.setUseCaches(false);//Don't use a cached Copy
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("ENCTYPE", "multipart/form-data");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            connection.setRequestProperty("uploaded_file",selectedFilePath);

            //creating new dataoutputstream
            dataOutputStream = new DataOutputStream(connection.getOutputStream());

            //writing bytes to data outputstream
            dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
                    + selectedFilePath + "\"" + lineEnd);

            dataOutputStream.writeBytes(lineEnd);

            //returns no. of bytes present in fileInputStream
            bytesAvailable = fileInputStream.available();
            //selecting the buffer size as minimum of available bytes or 1 MB
            bufferSize = Math.min(bytesAvailable,maxBufferSize);
            //setting the buffer as byte array of size of bufferSize
            buffer = new byte[bufferSize];

            //reads bytes from FileInputStream(from 0th index of buffer to buffersize)
            bytesRead = fileInputStream.read(buffer,0,bufferSize);

            //loop repeats till bytesRead = -1, i.e., no bytes are left to read
            while (bytesRead > 0){
                //write the bytes read from inputstream
                dataOutputStream.write(buffer,0,bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable,maxBufferSize);
                bytesRead = fileInputStream.read(buffer,0,bufferSize);
            }

            dataOutputStream.writeBytes(lineEnd);
            dataOutputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            serverResponseCode = connection.getResponseCode();
            String serverResponseMessage = connection.getResponseMessage();

            Log.i(TAG, "Server Response is: " + serverResponseMessage + ": " + serverResponseCode);

            //response code of 200 indicates the server status OK
            if(serverResponseCode == 200){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvFileName.setText("File Upload completed.\n\n You can see the uploaded file here: \n\n" + "http://coderefer.com/extras/uploads/"+ fileName);
                    }
                });
            }

            //closing the input and output streams
            fileInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(),"File Not Found",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "URL error!", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Cannot Read/Write File!", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
        return serverResponseCode;
    }
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(resultCode == Activity.RESULT_OK){
        if(requestCode == PICK_FILE_REQUEST){
            if(data == null){
                //no data present
                return;
            }


            Uri selectedFileUri = data.getData();
            selectedFilePath = FilePath.getPath(this,selectedFileUri);
            Log.i(TAG,"Selected File Path:" + selectedFilePath);

            if(selectedFilePath != null && !selectedFilePath.equals("")){
                tvFileName.setText(selectedFilePath);
            }else{
                Toast.makeText(getActivity(),"Cannot upload file to server",Toast.LENGTH_SHORT).show();
            }
        }
    }
}