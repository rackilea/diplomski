public DisplayImage2()
{
super("Image Display");
setSize(600, 600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
connection = SingletonConnection.getConnection();
// LOAD FROM BLOB
try
    {
        query = "SELECT * FROM photo WHERE pkPhoto=?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, 61);
        result = statement.executeQuery();

        while ( result.next() )
            {
                byteArray = result.getBytes("photoImage");
                image = Toolkit.getDefaultToolkit().createImage(byteArray);
                imageIcon = new ImageIcon(image);
            }

        labelPhoto = new JLabel();
        labelPhoto.setIcon(imageIcon);
        add(labelPhoto);
        setVisible(true);
        // SAVE TO BLOB

        blob = new javax.sql.rowset.serial.SerialBlob(byteArray);

        query = "INSERT INTO photo (photoName, photoImage) VALUES(?,?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, "Image Test");
        statement.setBlob(2, blob);
        statement.executeUpdate();
    }

catch (IOException e)
    {
        e.printStackTrace();
    }
catch (SQLException e)
    {
        e.printStackTrace();
    }
}