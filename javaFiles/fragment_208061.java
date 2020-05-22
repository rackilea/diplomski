public class TestFragment extends Fragment {

        private RecyclerView recyclerView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.testxml, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.google);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.google.com"));
                    getActivity().startActivity(i);
                }
            });

            return view;
        }


}