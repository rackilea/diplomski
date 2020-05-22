// headers must be set before streaming
response.setContentType("application/zip");
response.setHeader("Content-Disposition", "attachment;filename=cierresZ_a_tangonet" + java.time.LocalDate.now() + ".zip");

// stream straight to client
ZipOutputStream zipped_out = new ZipOutputStream(response.getOutputStream());

// Add zip entries and data here:
// Loop:
//    zipped_out.putNextEntry(...)
//    Generate XML, writing it straight to zipped_out
//      Remember to flush any streams/writers wrapped around zipped_out
//      Do not close zipped_out or wrappers of it
//        If that cannot be prevented, use a CloseShieldOutputStream (from Commons IO)
//    No need to call zipped_out.closeEntry()

// make sure to finish the zip stream
zipped_out.finish();