import static java.util.stream.Collectors.*;

List<Log> list = ...
Map<Contact, Log> logs = list.stream()
    .collect(groupingBy(Log::getContact,
        collectingAndThen(maxBy(Comparator.comparing(Log::getLastUpdated)), Optional::get)));