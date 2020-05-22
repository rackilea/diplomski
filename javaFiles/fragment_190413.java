package com.mti.controller.booking;

import java.io.ByteArrayInputStream;
@Controller
@RequestMapping(value = "/offlineBooking")
public class OfflineBookingController {
@RequestMapping(value = "/getInvoice")
public void getInvoice(ModelMap modelMap, @RequestParam(value = "bookingId", required = true) Integer bookingId,
        HttpServletResponse response) throws Exception {
    Document document = new Document();
    InputStream is = null;
    PdfWriter writer = null;
    try{
    String everything = bookingService.getBookingInvoiceData(bookingId);
    is = new ByteArrayInputStream(everything.getBytes("UTF-8"));
    response.setHeader("Expires", "0");
    response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
    response.setHeader("Pragma", "public");

    response.setContentType("application/pdf");
    response.setHeader("Content-Description"," File Transfer");
    response.setHeader("Content-Disposition","attachment; filename="+"BookingInvoice"+ bookingId+".pdf");
    response.setHeader("Content-Transfer-Encoding"," binary");
    writer = PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
    XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
    writer.flush();
    response.flushBuffer();
    }catch (Exception e) {
        logger.error("Error in generating invoice " , e);
    }finally{
        if(writer!=null){
            writer.close();
        }
        document.close();
        is.close();
    }

}