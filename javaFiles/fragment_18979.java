Log.e("TAG", "Size Of Array :" + childList.size() + "Position :" + childList);
Log.e("TAG", "Id" + childList.get(childPosition - 1 ).getId());
myDb.deleteCompany(childList.get(childPosition - 1 ).getId());
rvCompanies_view.removeViewAt(childPosition);
Log.e("TAG", "Size Of Array :" + childList.size() + "Position :" + childList);
adapterRecycler.notifyDataSetChanged();
Toast.makeText(getActivity().getApplicationContext(), "Company Deleted", Toast.LENGTH_SHORT).show();