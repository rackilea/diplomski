setRecords(1000);
// for first time when we have page=0, it should 
// be page =1;
// If last page is required and if page no crosses total count
                int displayCount = count/rows;
                int remainder = count%rows;
                page = (page<=displayCount?page:count==0?0:remainder==0?displayCount:displayCount+1);


                int to = (getRows() * getPage());
                int from = to - getRows();

                if (to > getRecords()) to = getRecords();

                if (from > to) {
                    from = 0;
                    page = 1;
                }

setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));

                if(getTotal() == 0) page =0;