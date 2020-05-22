public class StartFragment extends Fragment implements OnClickListener{

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.fragment_start, container, false);

    Button b = (Button) v.findViewById(R.id.save_keywords);
    b.setOnClickListener(this);
    return v;
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.save_keywords:

        ...

        break;
    }
}
}