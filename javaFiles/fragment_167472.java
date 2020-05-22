}catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }finally{
    try{
        rs.close();  //where rs = resultstatement
        pst.close();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}