for (Map.Entry<String,AcroFields.Item> entry : fields.entrySet()) {
    out.write(entry.getKey());
    item = entry.getValue();
    dict = item.getMerged(0);
    flags = dict.getAsNumber(PdfName.FF);
    if (flags != null && (flags.intValue() & BaseField.REQUIRED) > 0)
        out.write(" -> required\n");
}