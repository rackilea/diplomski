package com.hibernate.productData.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hibernate.productData.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
{
}