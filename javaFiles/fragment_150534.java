//Set into INSERT the values we SELECTEd
            ins.setString(1, rs.getString("MATERIAL_NUMBER")); 
            ins.setString(2, rs.getString("BATCH_NUMBER")); 
            ins.setString(3, rs.getString("VENDOR_BATCH_NUMBER")); 
            ins.setString(4, rs.getString("VENDOR_NUMBER"));      
            ins.setString(5, rs.getString("GOODS_SUPPLIER_NUMBER"));
            //6th value is always null as specified in INSERT
            ins.setTimestamp(6, rs.getTimestamp("MODIFIED_DATETIME"));