@Override
    public <E, U, V> E getObject(U arg0, V invId) throws Exception {
        ReceiptHdr receiptHdr = null;
        try {
            logger.info("--------Excute getData -->");

            JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);              
            receiptHdr = jdbcTemplate.queryForObject("select rcpt_id, hdr_remark, currency, rate_value, rcpt_st_date, rcpt_end_date, grand_total, tot_discount_amt, net_total, tot_paid_amt, cust_id, so_id, sale_inv_id, stat_code, current_inst_no,added_date, added_by from" + SchemaName.MIS + "receipt_hdr",
                    new RowMapper<ReceiptHdr>() {

                        public ReceiptHdr mapRow(ResultSet rs, int rowNum) throws SQLException {
                            logger.info("--------Excute check 2 -->");
                            ReceiptHdr rcptHdr = new ReceiptHdr();
                            rcptHdr.setRcptId(rs.getInt("rcpt_id"));
                            rcptHdr.setHdrRemark(rs.getString("hdr_remark"));
                            rcptHdr.setCurrency(rs.getString("currency"));
                            rcptHdr.setRateValue(rs.getBigDecimal("rate_value"));
                            rcptHdr.setRcptStDate(rs.getDate("rcpt_st_date"));
                            rcptHdr.setRcptEndDate(rs.getDate("rcpt_end_date"));
                            rcptHdr.setGrandTotal(rs.getBigDecimal("grand_total"));
                            rcptHdr.setTotDiscountAmt(rs.getBigDecimal("tot_discount_amt"));
                            rcptHdr.setNetTotal(rs.getBigDecimal("net_total"));
                            rcptHdr.setTotPaidAmt(rs.getBigDecimal("tot_paid_amt"));                        
                            rcptHdr.setAddedBy(rs.getString("added_by"));

                            SaleInvHdr salesInvHdr = new SaleInvHdr();
                            salesInvHdr.setSaleInvId(rs.getShort("sale_inv_id"));
                            rcptHdr.setSaleInvHdr(salesInvHdr);

                            SoHdr soHdr = new SoHdr();
                            soHdr.setSoId(rs.getShort("so_id"));
                            rcptHdr.setSoHdr(soHdr);

                            Customer customer = new Customer();
                            customer.setCustId(rs.getShort("cust_id"));
                            rcptHdr.setCustomer(customer);

                            rcptHdr.setAddedDate(rs.getDate("added_date"));
                            rcptHdr.setStatCode(rs.getShort("stat_code"));
                            rcptHdr.setCurrentInstNo(rs.getShort("current_inst_no"));

                            return rcptHdr;
                        }
                    });

            receiptHdr.setReceiptDets((jdbcTemplate.query("select rcpt_det_id,rcpt_date,paid_amt,instmnt_no,outstnd_amt, delete_comment,added_date from" + SchemaName.MIS + "receipt_det", new RowMapper<ReceiptDet>() {
                public ReceiptDet mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ReceiptDet receiptDet = new ReceiptDet();
                    receiptDet.setRcptDetId(rs.getInt("rcpt_det_id"));
                    receiptDet.setRcptDate(rs.getDate("rcpt_date"));
                    receiptDet.setPaidAmt(rs.getBigDecimal("paid_amt"));
                    receiptDet.setInstmntNo(rs.getShort("instmnt_no"));
                    receiptDet.setOutstndAmt(rs.getBigDecimal("outstnd_amt"));
                    receiptDet.setDeleteComment(rs.getString("delete_comment"));
                    receiptDet.setAddedDate(rs.getDate("added_date"));
                    return receiptDet;
                }
            })));

            logger.info("--------getData ReceiptHdr--> " + receiptHdr);
            logger.info("--------getData ReceiptHdr--> " + receiptHdr.getReceiptDets().size());
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            logger.error("Error : Get Data-->" + e);
        }

        return (E) receiptHdr;
    }