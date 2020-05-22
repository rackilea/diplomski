@Override 
    public View getView()
    {
        View row = null;
            if (activity.equalsIgnoreCase("Ni_activity") || activity.equalsIgnoreCase("Current_NI_Activity") || activity.equalsIgnoreCase("Ni_Test_Activity")) {
                row = inflater.inflate(R.layout.ni_spinner_row, parent, false);
            } else if (activity.equalsIgnoreCase("RFTestActivity")) {
                row = inflater.inflate(R.layout.spinner_row, parent, false);
            } else if (activity.equalsIgnoreCase("SiteInfoFragment") || activity.equalsIgnoreCase("LayerInfoFragment")) {
                row = inflater.inflate(R.layout.site_frag_spinner, parent, false);
            }

            TextView tvCategory = (TextView) row.findViewById(R.id.tvCategory);
            tvCategory.setTypeface(null, Typeface.BOLD);
            try {
                tvCategory.setText(data.get(position));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return row;
    }