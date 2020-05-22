public void setTexts(ResultSet rs) 
{
    tfResultsTitle.setText(rs.getString("Title"));
    tfResultsReleaseT.setText(rs.getString("ReleaseType"));
    tfResultsType.setText(rs.getString("Type"));
    tfResultsGenre.setText(rs.getString("Genre"));
    tfResultsPrice.setText(rs.getString("Price"));
    tfResultsDeal.setText(rs.getString("Deal"));
    tfResultsInStock.setText(rs.getString("InStock"));
    tfResultsLastRec.setText(rs.getString("LastRec"));
    tfResultsLastSold.setText(rs.getString("LastSold"));
    tfResultsBarcode.setText(rs.getString("Barcode"));
}