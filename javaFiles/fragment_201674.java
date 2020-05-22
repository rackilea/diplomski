PdfPTable tablesup= new PdfPTable(4);

                    PdfPCell cell = new PdfPCell(new Paragraph("Supplier Information"));
                    cell.setColspan(8);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.CYAN);

                    tablesup.addCell(cell);

                    tablesup.addCell("Supplier ID");
                    tablesup.addCell("Supplier Name");
                    tablesup.addCell("Address");
                    tablesup.addCell("Contact Info");

                while(rs.next()){

                String v1 = rs.getString("SupplierID");
                String v2 = rs.getString("SupplierName");
                String v3 = rs.getString("Address");
                String v4 = rs.getString("ContactInfo");

                tablesup.addCell(v1);
                tablesup.addCell(v2);
                tablesup.addCell(v3);
                tablesup.addCell(v4); 

                }

                pdfsup.add(tablesup);
                pdfsup.close();
                JOptionPane.showMessageDialog(null, "Report Saved...");