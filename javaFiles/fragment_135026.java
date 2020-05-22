LayoutInflater lf = getActivity().getLayoutInflater();
            View view =  lf.inflate(R.layout.fragment_home_page, container, false);

            username = (TextView) view .findViewById(R.id.username);
            followersNr = (Button) view .findViewById(R.id.followersNr);
            donatedNr = (Button)view .findViewById(R.id.donatedNr);
            totalKmNr = (Button) view .findViewById(R.id.totalKmNr);
            pointsNr = (Button) view .findViewById(R.id.pointsNr);
            followersText = (Button) view .findViewById(R.id.followersNr);
            donatedText = (Button) view .findViewById(R.id.donatedLink);
            totalKmText = (Button) view .findViewById(R.id.totalKmLink);
            pointsText = (Button) view .findViewById(R.id.pointsLink);

            homePageDetails();

            return view ;