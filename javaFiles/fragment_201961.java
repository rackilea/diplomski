if (resp.equals("Nothing to display"))
  {
      Toast.makeText(getContext(), "Nothing to Display", Toast.LENGTH_SHORT).show();
      bl = new BS_allList(getActivity(),{""},{""},{""},{""},{""});
      lv_bsall.setAdapter(bl);
  }