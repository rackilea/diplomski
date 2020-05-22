public void onClick(View v)
            {
                ls_docno = new ArrayList<String>(Arrays.asList(doc_no));
                ls_balance = new ArrayList<String>(Arrays.asList(balance));
                ls_total =new ArrayList<String>(Arrays.asList(total));
                ls_vat= new ArrayList<String>(Arrays.asList(vat));
                ls_profit =new ArrayList<String>(Arrays.asList(profit));

                ls_docno.remove(pos);
                ls_balance.remove(pos);
                ls_total.remove(pos);
                ls_profit.remove(pos);
                ls_vat.remove(pos);

                Log.d("POSITION",String.valueOf(pos));

                for (int i=pos; i< ls_docno.size(); i++)
                {
                    if(i>0)
                    {
                        String doc= ls_docno.get(i-1);
                        String inv_no = doc.replaceAll("[^0-9]", "");
                        int new_invno = Integer.parseInt(inv_no);
                        new_invno++;
                        ls_docno.set(i,"IN"+new_invno);

                    }

                }

                doc_no = ls_docno.toArray(new String[ls_docno.size()]);
                balance = ls_balance.toArray(new String[ls_balance.size()]);
                total = ls_total.toArray(new String[ls_total.size()]);
                profit = ls_profit.toArray(new String[ls_profit.size()]);
                vat = ls_profit.toArray(new String[ls_vat.size()]);

                bl = new BS_allList(ReportGenerator.this, doc_no, balance, total, vat, profit);
                lv_bsall.setAdapter(bl);


                delete_expense.dismiss();

            }