public Fragment getItem(int position) {
        while (position < companies.size() - 1) {
            if (position < companies.size() - 1) {
                position++;
                return FragmentUserDetails.newInstance(companies.get(position));
            }
        }
        return null;
    }