ALTER PROCEDURE [dbo].[BronzeLabsCreateServiceEquipment]
    @companyID int = null,
    @manufacturerID int = null,
    @modelID int = null,
    @serialNumber varchar(255) = '',
    @machine varchar(255) = '',
    @location varchar(255) = ''
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO ServiceEquipment(CompanyID, ManufacturerID, ModelID, SerialNumber, Machine, Location)
    VALUES (@companyID, @manufacturerID, @modelID, @serialNumber, @machine, @location)

    SELECT SCOPE_IDENTITY() AS equipmentID

END