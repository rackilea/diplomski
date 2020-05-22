void beforeCommit() {
  if in special transaction
    if commit flag not set
       throw new RuntimeException("cancel transaction")
    end if
  end if
end