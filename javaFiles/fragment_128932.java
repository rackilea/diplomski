POST https://www.googleapis.com/calendar/v3/calendars/my_calendar@gmail.com/events/watch
Authorization: Bearer auth_token_for_current_user
Content-Type: application/json

{
  "id": "01234567-89ab-cdef-0123456789ab", // Your channel ID.
  "type": "web_hook",
  "address": "https://exampledomain.com/notifications", // Your receiving URL.
  ...
  "token": "target=myApp-myCalendarChannelDest", // (Optional) Your channel token.
  "expiration": 1426325213000 // (Optional) Your requested channel expiration time.
  }
}