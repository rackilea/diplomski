async function deleteSelected() {
    for (const propertyId of this.selectedProperties) {
        await this.metadataPropertyService.deleteProperty(this.packageName, propertyId)
    }
    this.ngOnChanges();
}