public void PrintInvoiceSection() throws JRException, SQLException, PrinterException {

        try {
            String sql2 = "select pr_id as printId, pr_printer as printName from invoices_items where tr_inv_no='" + inv_id + "' Group BY pr_id";
            rs = con.createStatement().executeQuery(sql2);
            while (rs.next()) {
                int prind = rs.getInt("printId");
                String prnam = rs.getString("printName");
                JasperDesign jasperdesign = JRXmlLoader.load("C:\\Users\\Wael\\Documents\\NetBeansProjects\\resrr\\resturnopos\\src\\printer\\Printsection.jrxml");

                String sql = "SELECT resturno.mr_printsection.pr_section,\n" +
"   resturno.invoices_items.tr_it_name,\n" +
"       resturno.invoices_items.tr_date,\n" +
"       resturno.invoices_items.tr_inv_issued,\n" +
"   resturno.invoices_items.tr_it_price,\n" +
"   resturno.invoices_items.tr_vat,\n" +
"   resturno.invoices_items.tr_it_qty,\n" +
"   resturno.invoices_items.tr_it_tot,\n" +
"   resturno.invoices_items.tr_inv_no,\n" +
"   resturno.mr_invoicetyp.inv_name1,\n" +
"   resturno.invoices_items.inv_typ_id,\n" +
"   resturno.invoices_items.tr_it_name,\n" +
"   resturno.invoices_items.tr_it_price,\n" +
"   resturno.invoices_items.tr_vat,\n" +
"   resturno.invoices_items.tr_it_tot,\n" +
"   resturno.invoices_items.tr_it_qty,\n" +
"   resturno.mr_invoicetyp.inv_name1,\n" +
"   resturno.mr_invoicetyp.inv_name2,\n" +
"   resturno.mr_printsection.pr_section,\n" +
"   resturno.invoices_items.pr_id,\n" +
"   resturno.invoices_items.pr_printer\n" +
"FROM resturno.invoices_items\n" +
"   INNER JOIN resturno.mr_invoicetyp ON \n" +
"    resturno.mr_invoicetyp.inv_typ_id = resturno.invoices_items.inv_typ_id \n" +
"   INNER JOIN resturno.mr_printsection ON \n" +
"    resturno.mr_printsection.pr_id = resturno.invoices_items.pr_id \n" +
"WHERE  \n"
                    + "  resturno.invoices_items.tr_inv_no = '" + inv_id + "' \n"
                    + "  AND resturno.invoices_items.pr_id = '" + prind + "'"
                    + "  AND resturno.invoices_items.pr_printer = '" + prnam + "'";
                JRDesignQuery jrq = new JRDesignQuery();
                jrq.setText(sql);
                jasperdesign.setQuery(jrq);
                JasperReport jsp = JasperCompileManager.compileReport(jasperdesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jsp, new HashMap(), con);
//              List jpList = new ArrayList();
//              jpList.add(j.loadObjectFromFile("build/reports/Report1.jrprint")); 
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setVisible(true);
                PrintReportToPrinterSection(jasperPrint, prnam);
            }
        } catch (JRException ex) {
            System.out.println(ex);
        }
    }