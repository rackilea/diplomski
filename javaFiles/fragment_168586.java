@Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "tab1 name";
                case 1:
                    return "tab2 name";
            }
            return null;
        }