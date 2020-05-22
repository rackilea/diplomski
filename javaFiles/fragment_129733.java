import com.datastax.driver.core.utils.UUIDs;

UUID timeUUID = UUIDs.timeBased();

String timeUUIDString = timeUUID.toString();
vars.put("timeUUID", timeUUIDString);
//etc.