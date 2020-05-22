import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ...

LocalDate fechaActual = LocalDate.now();
LocalDate fechaPasada = LocalDate.of(1970, 1, 1);

LocalDate fechNac = LocalDate.parse(persona.getFechNac(),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));

if (fechNac.isAfter(fechaPasada) && fechaActual.isBefore(fechNac)) {
    // ...
}