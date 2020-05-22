<t:inputCalendar id="dob"  
    maxlength="10" 
    value="#{myBackingBean.person.dateOfBirth}"
    monthYearRowClass="monthYearRowClass" 
    weekRowClass="weekRowClass" 
    dayCellClass="dayCellClass" 
    currentDayCellClass="currentDayCellClass"
    popupTodayString="HERE_GOES_EMPTY_STRING" 
    popupWeekString="Wk" renderAsPopup="true"
    renderPopupButtonAsImage="true" 
    popupDateFormat="MM/dd/yyyy"
    alt="Calendar" title="Calendar">
 </t:inputCalendar>