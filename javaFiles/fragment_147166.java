private String getCalendarUriBase(Activity act) {

                String calendarUriBase = null;
                Uri calendars = Uri.parse("content://calendar/calendars");
                Cursor managedCursor = null;
                try {
                    managedCursor = act.managedQuery(calendars, null, null, null, null);
                } catch (Exception e) {
                }
                if (managedCursor != null) {
                    calendarUriBase = "content://calendar/";
                } else {
                    calendars = Uri.parse("content://com.android.calendar/calendars");
                    try {
                        managedCursor = act.managedQuery(calendars, null, null, null, null);
                    } catch (Exception e) {
                    }
                    if (managedCursor != null) {
                        calendarUriBase = "content://com.android.calendar/";
                    }
                }
                return calendarUriBase;