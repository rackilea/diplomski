adapter.sort(new Comparator<Ledger>() {
                public int compare(MyObject lhs, MyObject rhs) {
                    return  rhs.transaction_date.compareTo(lhs.transaction_date);
                }
            });
            notifyDataSetChanged();