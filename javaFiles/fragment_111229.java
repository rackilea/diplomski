return Normalizer
    .normalize(src.trim().toLowerCase(Locale.ENGLISH),
        Normalizer.Form.NFD)
    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
    .replaceAll("[^\\p{ASCII}]+", "-")
    .replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)+", "");