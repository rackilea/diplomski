forAtLeast(1, reasons.items) { item =>
  item.status must be ("ACTIVE")
}

forAtLeast(1, reasons.items) { item =>
  item.status must be ("INACTIVE")
}