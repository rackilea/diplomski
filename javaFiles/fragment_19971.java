public MyFragment extends Fragment{

@Override
public void onCreateView(....){
 ((ExternalInterface )getActivity()).gotoNext();
 }
}