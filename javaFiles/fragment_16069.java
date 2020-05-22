public class BottomSheet extends BottomSheetDialogFragment {

AdapterMessage adapterMessage;
ArrayList<MessageModel> messageList;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.bottom_sheet, container, false);

    return view;
}
}