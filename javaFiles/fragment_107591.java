@Entity
@Table(name = "user")
public class User implements Serializable {

    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private Set<Car> cars;

    public Set<Car> getCars(){
        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
        car.setUser(this);
    }
}

@Entity
@Table(name = "car")
public class Car implements Serializable {

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
}

@Override
public Set<Car> findCars(Long userId) {
    return userRepository.findOne(userId).getCars();
}