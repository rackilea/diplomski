LocalDate userBeginning = // …
      LocalDate userEnd = // …
      LocalDateTime userBeginningTime = userBeginning.atStartOfDay();
      LocalDateTime userEndTime = userEnd.plusDays(1).atStartOfDay();

      if (! b.getBeginning().isBefore(userBeginningTime)
                && ! b.getEnd().isAfter(userEndTime)) {
          bookingsForRoomInPeriod.add(b);
      }