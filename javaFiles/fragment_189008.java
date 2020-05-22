vacanyModelList = new ArrayList<>();
    public SuitableAdapter(Context context, int resource) {
            super(context, resource, objects);
            //don't set your object in constructor
            sqlHelper = new SQLHelper(getContext());

            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, @NonNull final ViewGroup parent) {
            ViewHolder holder = null;

            rowType = getItemViewType(position);

            if (convertView == null) {
                holder = new ViewHolder();

                switch (rowType) {
                    case TYPE_SEPARATOR:
                        convertView = inflater.inflate(R.layout.suitable_separator_layout, null);
                        holder.headerTv = (TextView) convertView.findViewById(R.id.section_header);

                        break;

                    case TYPE_ITEM:
                        convertView = inflater.inflate(R.layout.row_layout, null);
                        holder.tvProfession = (TextView) convertView.findViewById(R.id.tvProfession);
                        holder.tvHeader = (TextView) convertView.findViewById(R.id.tvHeader);
                        holder.tvSalary = (TextView) convertView.findViewById(R.id.tvSalary);
                        holder.tvDate = (TextView) convertView.findViewById(R.id.tvPostCr);
                        break;
                }

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (getItemViewType(position) == TYPE_SEPARATOR) {

                holder.headerTv = (TextView) convertView.findViewById(R.id.section_header);

                if (newRecs == 1) {
                    holder.headerTv.setText("Новые вакансии");
                    newRecs = 0;
                } else {
                    holder.headerTv.setText("Ранее просмотренные");
                }
            }

            if (getItemViewType(position) == TYPE_ITEM) {

                final VacancyModel model = vacancyModelList.get(position);

                holder.tvProfession.setText(model.getProfession());
                holder.tvHeader.setText(model.getHeader());
                holder.tvSalary.setText(model.getSalary());
                holder.tvDate.setText(model.getDate());

                Date date;
                try {
                    if (saveLastDate == null) {
                        saveLastDate = model.getDate();
                    } else {
                        date = stringToDate(saveLastDate);
                        if (date.before(stringToDate(model.getDate()))) {
                            saveLastDate = model.getDate();
                        }
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
          VacancyModel model = getItem(position);
            if (model.isHeading) {
                return TYPE_SEPARATOR;
            } else {
              return TYPE_ITEM;
                   }
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getCount() {
            return vacancyModelList.size();
        }

        private Date stringToDate(String string) throws ParseException {
            return new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"), Locale.getDefault()).parse(string);
        }

        private static class ViewHolder {
            private TextView tvProfession;
            private TextView tvHeader;
            private TextView tvSalary;
            private TextView tvDate;

            private TextView headerTv;
        }

        public void setUpdatedData(List<VacancyModel> updated_list)
        {
          this.vacancyModelList = updated_list;
          notifyDataSetChanged();
        }