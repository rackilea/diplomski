public void receive(Map<String, String> result) {
  getActivity().runOnUiThread(new Runnable() {
    @Override
    public void run() {
      tv0.setText(result.get("platform"));
      tv1.setText(result.get("board-name"));
      tv2.setText(result.get("version"));
      tv3.setText(result.get("uptime"));
      tv4.setText(String.format("%s %%", result.get("cpu-load")));
      tv5.setText(String.format("%s MB", Integer.parseInt(result.get("free-memory")) / (1024*1024)));
      tv6.setText(String.format("%s MB", Integer.parseInt(result.get("total-memory")) / (1024*1024)));
      tv7.setText(String.format("%s MB", Integer.parseInt(result.get("free-hdd-space")) / (1024*1024)));
      tv8.setText(String.format("%s MB", Integer.parseInt(result.get("total-hdd-space")) / (1024*1024)));
  });
}