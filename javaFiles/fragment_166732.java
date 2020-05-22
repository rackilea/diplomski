while (businessDayCounter < 3) {

    // determine if this day is a holiday
    DiaFestivoDTO dia = new DiaFestivoDTO();
    dia.setFechaInitial(cal.getTime());
    dia.setFechaLimite(cal.getTime());
    boolean isHoliday = seleccionPagoBO.obtenerDiasFestivos(dia) > 0;

    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !isHoliday) {
        businessDayCounter++;
    }
    cal.add(Calendar.DAY_OF_YEAR, 1);
}