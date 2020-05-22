public class AttachmentsFragment extends Fragment {


public static final int PERMISSIONS_REQUEST_CODE = 0;
public static final int FILE_PICKER_REQUEST_CODE = 1;

public AttachmentsFragment() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_attachments, container, false);

    Button pickButton = view.findViewById(R.id.btn_choose_files);
    pickButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkPermissionsAndOpenFilePicker();
        }
    });

    return view;
}

private void checkPermissionsAndOpenFilePicker() {
    String permission = Manifest.permission.READ_EXTERNAL_STORAGE;

    if (ContextCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)) {
            showError();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, PERMISSIONS_REQUEST_CODE);
        }
    } else {
        openFilePicker();
    }
}

private void openFilePicker() {
    new MaterialFilePicker()
            .withSupportFragment(this)
            .withRequestCode(FILE_PICKER_REQUEST_CODE)
            .withHiddenFiles(true)
            .withTitle("Sample title")
            .start();
}

private void showError() {
    Toast.makeText(getContext(), "Allow external storage reading", Toast.LENGTH_SHORT).show();
}

@Override
public void onRequestPermissionsResult(int requestCode,
                                       @NonNull String permissions[], @NonNull int[] grantResults) {
    switch (requestCode) {
        case PERMISSIONS_REQUEST_CODE: {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openFilePicker();
            } else {
                showError();
            }
        }
    }
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
        String path = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);

        if (path != null) {
            Log.d("Path (fragment): ", path);
            Toast.makeText(getContext(), "Picked file in fragment: " + path, Toast.LENGTH_LONG).show();
        }
    }
}