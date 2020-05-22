// Run a query again the IMAGE table to fetch the image with the given id
public Image readImage(Connection conn, int id) throws SQLException {
  PreparedStatement pstmt = null;
  try {
    pstmt = conn.prepareStatement("SELECT contents FROM image WHERE id = ?");
    pstmt.setInt(1, id); 
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      InputStream is = rs.getBinaryStream(1);
      return ImageIO.read(is);
    } else {
      return null;
    }
  } finally {
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (SQLException ignored) {
      }
    }
  }
}

// Display the given Image on a Swing frame
public void showImage(final Image img) {
  JFrame frame = new JFrame("Image");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(img.getWidth(), img.getHeight());
  frame.add(new JPanel() {
    public void paint(Graphics g) {
      g.drawImage(img, 0, 0, null);
    }
  });
  frame.show();
}