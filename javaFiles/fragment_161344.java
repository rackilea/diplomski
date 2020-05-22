import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

// ...

// Initialize Calendar service with valid OAuth credentials
Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
    .setApplicationName("applicationName").build();

// Retrieve the event from the API
Event event = service.events().get("primary", "eventId").execute();

// Make a change
event.setSummary("Appointment at Somewhere");

// Update the event
Event updatedEvent = service.events().update("primary", event.getId(), event).execute();

System.out.println(updatedEvent.getUpdated());